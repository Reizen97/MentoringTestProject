package com.mentoring.api.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class MessageResponse {

    private String status;
    @SerializedName(value = "data", alternate = {"message"})
    private String data;
}
