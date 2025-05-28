package com.anikanov02.selfhost.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Model {
    DEEPSEEK_CODER("deepseek-coder-v2"),
    DEEPSEEK_V3("deepseek-v3"),
    DEEPSEEK_R1("deepseek-r1");

    private final String name;
}
