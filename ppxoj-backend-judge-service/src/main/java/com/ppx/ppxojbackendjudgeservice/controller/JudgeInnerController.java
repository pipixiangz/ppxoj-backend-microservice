package com.ppx.ppxojbackendjudgeservice.controller;

import com.ppx.ppxojbackendjudgeservice.judge.JudgeService;
import com.ppx.ppxojbackendmodel.model.entity.QuestionSubmit;
import com.ppx.ppxojbackendserviceclient.service.JudgeFeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 服务内部互相调用的一些接口,不给前端
 */
@RestController
@RequestMapping("/inner")
public class JudgeInnerController implements JudgeFeignClient {

    @Resource
    private JudgeService judgeService;

    /**
     * 判题
     *
     * @param questionSubmitId
     * @return
     */
    @Override
    @PostMapping("/do")
    public QuestionSubmit doJudge(@RequestParam("questionSubmitId") long questionSubmitId) {
        return judgeService.doJudge(questionSubmitId);
    }

}
