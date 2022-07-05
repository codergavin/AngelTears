package com.ruoyi.common.utils.hrms.entity;

/**
 * @author Gavin Li
 * @version 1.0
 * @group HummingBird
 * @date 2022/7/5 9:31
 * @desc
 */
public class TokenEntity {
    private String token;
    //expiresIn: toke有效期，单位秒：秒；如果在有效期内重复获取，token不变，token的有效期会重置为7200秒
    private Integer expiresIn;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TokenEntity{");
        sb.append("token='").append(token).append('\'');
        sb.append(", expiresIn=").append(expiresIn);
        sb.append('}');
        return sb.toString();
    }
}
