package com.easyqa.qa.pages.util;

import io.qameta.allure.Step;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter(onMethod=@__({@Step}))
public class UserData {
    private final String userName;
    private final String userPassword;
}

