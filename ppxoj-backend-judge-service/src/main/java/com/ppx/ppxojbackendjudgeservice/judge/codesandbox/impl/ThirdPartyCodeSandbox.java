package com.ppx.ppxojbackendjudgeservice.judge.codesandbox.impl;


import com.ppx.ppxojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import com.ppx.ppxojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.ppx.ppxojbackendmodel.model.codesandbox.ExecuteCodeRequest;

public class ThirdPartyCodeSandbox implements CodeSandbox {
    /**
     * 调用网上现成的代码沙箱
     *
     * @param executeCodeRequest
     * @return
     */
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }

}
