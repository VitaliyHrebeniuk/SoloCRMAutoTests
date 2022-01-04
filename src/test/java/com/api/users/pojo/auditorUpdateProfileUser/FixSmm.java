package com.api.users.pojo.auditorUpdateProfileUser;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FixSmm{
    @JsonProperty("1_")
    public boolean _1_;
    @JsonProperty("2_") 
    public boolean _2_;
    @JsonProperty("3_") 
    public boolean _3_;
    @JsonProperty("4_") 
    public boolean _4_;
    @JsonProperty("5_") 
    public boolean _5_;

    public FixSmm(boolean _1_, boolean _2_, boolean _3_, boolean _4_, boolean _5_) {
        this._1_ = _1_;
        this._2_ = _2_;
        this._3_ = _3_;
        this._4_ = _4_;
        this._5_ = _5_;
    }
}
