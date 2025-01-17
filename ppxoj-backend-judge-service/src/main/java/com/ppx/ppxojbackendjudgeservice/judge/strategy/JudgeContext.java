package com.ppx.ppxojbackendjudgeservice.judge.strategy;


import com.ppx.ppxojbackendmodel.model.codesandbox.JudgeInfo;
import lombok.Data;
import com.ppx.ppxojbackendmodel.model.entity.Question;
import com.ppx.ppxojbackendmodel.model.entity.QuestionSubmit;
import com.ppx.ppxojbackendmodel.model.dto.question.JudgeCase;

import java.util.List;

/**
 * 上下文（用于定义在策略中传递的参数）
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;

}