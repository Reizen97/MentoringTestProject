package com.mentoring.api.response;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Setter
@Getter
@AllArgsConstructor
public class EmployeeResponse {

    private String id;
    @SerializedName("employee_name")
    private String name;
    @SerializedName("employee_salary")
    private String salary;
    @SerializedName("employee_age")
    private String age;
    @SerializedName("profile_image")
    private String profileImage;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof EmployeeResponse)) return false;
        EmployeeResponse that = (EmployeeResponse) o;

        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getSalary(), that.getSalary()) &&
                Objects.equals(getAge(), that.getAge()) &&
                Objects.equals(getProfileImage(), that.getProfileImage());
    }
}
