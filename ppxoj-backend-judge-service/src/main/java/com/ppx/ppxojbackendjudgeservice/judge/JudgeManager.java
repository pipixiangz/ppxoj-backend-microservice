package com.ppx.ppxojbackendjudgeservice.judge;


import com.ppx.ppxojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import com.ppx.ppxojbackendjudgeservice.judge.strategy.JudgeStrategy;
import com.ppx.ppxojbackendmodel.model.codesandbox.JudgeInfo;
import org.springframework.stereotype.Service;
import com.ppx.ppxojbackendmodel.model.entity.QuestionSubmit;
import com.ppx.ppxojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.ppx.ppxojbackendjudgeservice.judge.strategy.JudgeContext;

/**
 * 判题管理（简化调用/封装）
 * 目的: 尽量简化对判题功能的调用
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     * 以及对于判题策略的选取
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}