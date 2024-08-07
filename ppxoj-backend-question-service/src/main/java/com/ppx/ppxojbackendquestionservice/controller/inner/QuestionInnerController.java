package com.ppx.ppxojbackendquestionservice.controller.inner;

import com.ppx.ppxojbackendmodel.model.entity.Question;
import com.ppx.ppxojbackendmodel.model.entity.QuestionSubmit;
import com.ppx.ppxojbackendquestionservice.service.QuestionService;
import com.ppx.ppxojbackendquestionservice.service.QuestionSubmitService;
import com.ppx.ppxojbackendserviceclient.service.QuestionFeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 服务内部互相调用的一些接口,不给前端
 */
@RestController
@RequestMapping("/inner")
public class QuestionInnerController implements QuestionFeignClient {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;

    /**
     * 根据题目ID获取题目
     *
     * @param questionId
     * @return
     */
    @Override
    @GetMapping("/get/id")
    public Question getById(@RequestParam("questionId") long questionId) {
        return questionService.getById(questionId);
    }

    /**
     * 根据题目提交ID获取题目
     *
     * @param questionSubmitId
     * @return
     */
    @Override
    @GetMapping("question_submit/get/id")
    public QuestionSubmit getQuestionSubmitById(@RequestParam("questionSubmitId") long questionSubmitId) {
        return questionSubmitService.getById(questionSubmitId);
    }

    /**
     * 根据题目ID获取题目列表
     *
     * @param questionSubmit
     * @return
     */
    @Override
    @PostMapping("/question_submit/update")
    public boolean updateById(@RequestBody QuestionSubmit questionSubmit) {
        return questionSubmitService.updateById(questionSubmit);
    }

    /**
     * 根据题目ID更改Accepted数量
     *
     * @param question
     * @return
     */
    @Override
    @PostMapping("/question/update")
    public boolean updateQuestionById(@RequestBody Question question) {
        return questionService.updateById(question);
    }

}
