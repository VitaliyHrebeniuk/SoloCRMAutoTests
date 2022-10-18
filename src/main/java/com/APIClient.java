/**
 * TestRail API binding for Java (API v2, available since TestRail 3.0)
 * Updated for TestRail 5.7
 *
 * Learn more:
 *
 * http://docs.gurock.com/testrail-api2/start
 * http://docs.gurock.com/testrail-api2/accessing
 *
 * Copyright Gurock Software GmbH. See license.md for details.
 */
 
package com;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;


public class APIClient
{
	private String m_user;
	private String m_password;
	private String m_url;

	public APIClient(String base_url)
	{
		if (!base_url.endsWith("/"))
		{
			base_url += "/";
		}
		
		this.m_url = base_url + "index.php?/api/v2/";
	}

	/**
	 * Получить/установить пользователя
	 *
	 * Возвращает/задает пользователя, используемого для аутентификации запросов API.
	 */
	public String getUser()
	{
		return this.m_user;
	}

	public void setUser(String user)
	{
		this.m_user = user;
	}

	/**
	 * Получить/установить пароль
	 *
	 * Возвращает/задает пароль, используемый для аутентификации запросов API.
	 */
	public String getPassword()
	{
		return this.m_password;
	}

	public void setPassword(String password)
	{
		this.m_password = password;
	}

	/**
	 * GET
	 * *
	 * * Отправляет запрос GET (чтение) к API и возвращает результат
	 * * (как объект, см. ниже).
	 * *
	 * * Аргументы:
	 * *
	 * * uri 		Метод API для вызова, включая параметры
	 * * 			(например, get_case/1)
	 * *
	 * * Возвращает проанализированный ответ JSON в виде стандартного объекта, который может
	 * * быть экземпляром JSONObject или JSONArray (в зависимости от
	 * * Метод API). В большинстве случаев это возвращает экземпляр JSONObject, который
	 * * в основном то же самое, что и java.util.Map.
	 * *
	 * * Если 'get_attachment/:attachment_id', возвращает строку
	 */
	public Object sendGet(String uri, String data)
		throws MalformedURLException, IOException, APIException
	{
		return this.sendRequest("GET", uri, data);
	}
	
	public Object sendGet(String uri)
			throws MalformedURLException, IOException, APIException
	{
		return this.sendRequest("GET", uri, null);
	}

	/**
	 * POST
	 * *
	 * * Отправляет запрос POST (запись) к API и возвращает результат
	 * * (как объект, см. ниже).
	 * *
	 * * Аргументы:
	 * *
	 * * uri 			Метод API для вызова, включая параметры
	 * * 				(например, add_case/1)
	 * * data 		Данные для отправки в рамках запроса (например,
	 * *                      карта)
	 * * При добавлении вложения должен быть путь
	 * * в файл
	 * *
	 * * Возвращает проанализированный ответ JSON в виде стандартного объекта, который может
	 * * быть экземпляром JSONObject или JSONArray (в зависимости от
	 * * Метод API). В большинстве случаев это возвращает экземпляр JSONObject, который
	 * * в основном то же самое, что и java.util.Map.
	 */
	public Object sendPost(String uri, Object data)
		throws MalformedURLException, IOException, APIException
	{
		return this.sendRequest("POST", uri, data);
	}
	
	private Object sendRequest(String method, String uri, Object data)
		throws MalformedURLException, IOException, APIException
	{
		URL url = new URL(this.m_url + uri);
		// Создаем объект подключения и устанавливаем требуемый метод HTTP
		// (GET/POST) и заголовки (тип контента и базовая аутентификация).
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		String auth = getAuthorization(this.m_user, this.m_password);
		conn.addRequestProperty("Authorization", "Basic " + auth);

		if (method.equals("POST"))
		{
			conn.setRequestMethod("POST");
			// Add the POST arguments, if any. We just serialize the passed
			// data object (i.e. a dictionary) and then add it to the
			// request body.
			if (data != null)
			{				
				if (uri.startsWith("add_attachment"))   // add_attachment API requests
				{
					String boundary = "TestRailAPIAttachmentBoundary"; //Can be any random string
					File uploadFile = new File((String)data);
					
					conn.setDoOutput(true);
					conn.addRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
					
					OutputStream ostreamBody = conn.getOutputStream();
					BufferedWriter bodyWriter = new BufferedWriter(new OutputStreamWriter(ostreamBody));
					
					bodyWriter.write("\n\n--" + boundary + "\r\n");
					bodyWriter.write("Content-Disposition: form-data; name=\"attachment\"; filename=\"" 
							+ uploadFile.getName() + "\"");
					bodyWriter.write("\r\n\r\n");
					bodyWriter.flush();
					
					//Read file into request
					InputStream istreamFile = new FileInputStream(uploadFile);
					int bytesRead;
					byte[] dataBuffer = new byte[1024];
					while ((bytesRead = istreamFile.read(dataBuffer)) != -1)
					{
						ostreamBody.write(dataBuffer, 0, bytesRead);
					}
					
					ostreamBody.flush();
					
					//end of attachment, add boundary
					bodyWriter.write("\r\n--" + boundary + "--\r\n");
					bodyWriter.flush();

					//Close streams
					istreamFile.close();
					ostreamBody.close();
					bodyWriter.close();
				}
				else	// Not an attachment
				{
					conn.addRequestProperty("Content-Type", "application/json");
					byte[] block = JSONValue.toJSONString(data).
						getBytes("UTF-8");
	
					conn.setDoOutput(true);
					OutputStream ostream = conn.getOutputStream();
					ostream.write(block);
					ostream.close();
				}
			}
		}
		else	// GET request
		{
			conn.addRequestProperty("Content-Type", "application/json");
		}
		
		// Execute the actual web request (if it wasn't already initiated
		// by getOutputStream above) and record any occurred errors (we use
		// the error stream in this case).
		int status = conn.getResponseCode();
		
		InputStream istream;
		if (status != 200)
		{
			istream = conn.getErrorStream();
			if (istream == null)
			{
				throw new APIException(
					"TestRail API return HTTP " + status + 
					" (No additional error message received)"
				);
			}
		}
		else 
		{
			istream = conn.getInputStream();
		}
		
        // If 'get_attachment/' returned valid status code, save the file
        if ((istream != null) && (uri.startsWith("get_attachment/")))
    	{      	
            FileOutputStream outputStream = new FileOutputStream((String)data);
 
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = istream.read(buffer)) > 0) 
            {
                outputStream.write(buffer, 0, bytesRead);
            }
 
            outputStream.close();
            istream.close();
            return (String) data;
        }
        	
        // Not an attachment received
		// Read the response body, if any, and deserialize it from JSON.
		String text = "";
		if (istream != null)
		{
			BufferedReader reader = new BufferedReader(
				new InputStreamReader(
					istream,
					"UTF-8"
				)
			);
		
			String line;
			while ((line = reader.readLine()) != null)
			{
				text += line;
				text += System.getProperty("line.separator");
			}
			
			reader.close();
		}
		
		Object result;
		if (!text.equals(""))
		{
			result = JSONValue.parse(text);
		}
		else 
		{
			result = new JSONObject();
		}
		
		// Check for any occurred errors and add additional details to
		// the exception message, if any (e.g. the error message returned
		// by TestRail).
		if (status != 200)
		{
			String error = "No additional error message received";
			if (result != null && result instanceof JSONObject)
			{
				JSONObject obj = (JSONObject) result;
				if (obj.containsKey("error"))
				{
					error = '"' + (String) obj.get("error") + '"';
				}
			}
			
			throw new APIException(
				"TestRail API returned HTTP " + status +
				"(" + error + ")"
			);
		}
		
		return result;
	}
	
	private static String getAuthorization(String user, String password)
	{
		try 
		{
			return new String(Base64.getEncoder().encode((user + ":" + password).getBytes()));
		}
		catch (IllegalArgumentException e)
		{
			// Not thrown
		}
		
		return "";
	}
}
