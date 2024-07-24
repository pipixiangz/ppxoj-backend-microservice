package com.ppx.ppxojbackendjudgeservice.judge.codesandbox.impl;

import com.ppx.ppxojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.ppx.ppxojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.ppx.ppxojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import com.ppx.ppxojbackendmodel.model.codesandbox.JudgeInfo;
import com.ppx.ppxojbackendmodel.model.enums.JudgeInfoMessageEnum;
import com.ppx.ppxojbackendmodel.model.enums.QuestionSubmitStatusEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ExampleCodeSandbox implements CodeSandbox {
    /**
     * 示例代码沙箱（仅仅为了跑通业务流程）
     *
     * @param executeCodeRequest
     * @return
     */
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();

        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }

}
