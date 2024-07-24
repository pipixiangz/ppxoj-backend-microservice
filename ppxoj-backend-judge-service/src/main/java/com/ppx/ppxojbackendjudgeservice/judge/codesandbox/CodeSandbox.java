package com.ppx.ppxojbackendjudgeservice.judge.codesandbox;


import com.ppx.ppxojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import com.ppx.ppxojbackendmodel.model.codesandbox.ExecuteCodeRequest;

public interface CodeSandbox {
    /**
     * 代码沙箱接口定义
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);

}
