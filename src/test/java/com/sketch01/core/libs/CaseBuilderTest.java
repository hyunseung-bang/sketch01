package com.sketch01.core.libs;

import org.junit.jupiter.api.Test;

class CaseBuilderTest {

    @Test
    public void test1() {

        int i = 5;

        CaseBuilder<String> caseBuilder = new CaseBuilder<String>();

        String result = new CaseBuilder<String>()
                        .whenthen(i == 1, "1")
                        .whenthen(i == 2, "2")
                        .elsethen("xxx")
                        .end();

        System.out.println("result = " + result);
    }
}