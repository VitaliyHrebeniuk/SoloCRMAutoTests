package com.api.users.pojo.auditorUpdateProfileUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MainRoot {
    public int userId;
    public String status;
    public String role;
    public String name;
    public String login;
    public String email;
    public String telegram;
    public Object password;
    public Object bid_id;
    public boolean lg;
    public boolean buying;
    public boolean offline;
    public boolean seo_access;
    public boolean result_access;
    public boolean client_stat_upload;
    public boolean retention;
    public boolean buying_control_rating;
    public boolean buying_control_sms;
    public boolean buying_control_reopen;
    public boolean importAccess;
    public List<Object> buyer_deals;
    public ProductDealTypeAccess product_deal_type_access;
    public List<Object> seo_project_ids;
    public List<Object> tags;
    public boolean operation_stats;

    public ProductDealTypeAccess getProduct_deal_type_access() {
        return product_deal_type_access;
    }

    public void setProduct_deal_type_access(ProductDealTypeAccess product_deal_type_access) {
        this.product_deal_type_access = product_deal_type_access;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public Object getBid_id() {
        return bid_id;
    }

    public void setBid_id(Object bid_id) {
        this.bid_id = bid_id;
    }

    public boolean isLg() {
        return lg;
    }

    public void setLg(boolean lg) {
        this.lg = lg;
    }

    public boolean isBuying() {
        return buying;
    }

    public void setBuying(boolean buying) {
        this.buying = buying;
    }

    public boolean isOffline() {
        return offline;
    }

    public void setOffline(boolean offline) {
        this.offline = offline;
    }

    public boolean isSeo_access() {
        return seo_access;
    }

    public void setSeo_access(boolean seo_access) {
        this.seo_access = seo_access;
    }

    public boolean isResult_access() {
        return result_access;
    }

    public void setResult_access(boolean result_access) {
        this.result_access = result_access;
    }

    public boolean isClient_stat_upload() {
        return client_stat_upload;
    }

    public void setClient_stat_upload(boolean client_stat_upload) {
        this.client_stat_upload = client_stat_upload;
    }

    public boolean isRetention() {
        return retention;
    }

    public void setRetention(boolean retention) {
        this.retention = retention;
    }

    public boolean isBuying_control_rating() {
        return buying_control_rating;
    }

    public void setBuying_control_rating(boolean buying_control_rating) {
        this.buying_control_rating = buying_control_rating;
    }

    public boolean isBuying_control_sms() {
        return buying_control_sms;
    }

    public void setBuying_control_sms(boolean buying_control_sms) {
        this.buying_control_sms = buying_control_sms;
    }

    public boolean isBuying_control_reopen() {
        return buying_control_reopen;
    }

    public void setBuying_control_reopen(boolean buying_control_reopen) {
        this.buying_control_reopen = buying_control_reopen;
    }

    public boolean isImportAccess() {
        return importAccess;
    }

    public void setImportAccess(boolean importAccess) {
        this.importAccess = importAccess;
    }

    public List<Object> getBuyer_deals() {
        return buyer_deals;
    }

    public void setBuyer_deals(List<Object> buyer_deals) {
        this.buyer_deals = buyer_deals;
    }


    public List<Object> getSeo_project_ids() {
        return seo_project_ids;
    }

    public void setSeo_project_ids(List<Object> seo_project_ids) {
        this.seo_project_ids = seo_project_ids;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public boolean isOperation_stats() {
        return operation_stats;
    }

    public void setOperation_stats(boolean operation_stats) {
        this.operation_stats = operation_stats;
    }
}
