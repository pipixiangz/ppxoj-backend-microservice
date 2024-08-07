package com.ppx.ppxojbackendserviceclient.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ppx.ppxojbackendmodel.model.dto.question.QuestionQueryRequest;
import com.ppx.ppxojbackendmodel.model.entity.Question;
import com.ppx.ppxojbackendmodel.model.entity.QuestionSubmit;
import com.ppx.ppxojbackendmodel.model.vo.QuestionVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 题目服务
 *
 */
@FeignClient(name = "ppxoj-backend-question-service", path = "/api/question/inner") //要和yml文件里的对应
public interface QuestionFeignClient {

    /**
     * 根据题目ID获取题目
     * @param questionId
     * @return
     */
    @GetMapping("/get/id")
    Question getById(@RequestParam("questionId") long questionId);

    /**
     * 根据题目提交ID获取题目
     * @param questionSubmitId
     * @return
     */
    @GetMapping("question_submit/get/id")
    QuestionSubmit getQuestionSubmitById(@RequestParam("questionSubmitId") long questionSubmitId);

    /**
     * 根据题目ID获取题目列表
     * @param questionSubmit
     * @return
     */
    @PostMapping("/question_submit/update")
    boolean updateById(@RequestBody QuestionSubmit questionSubmit);

    /**
     * 根据题目ID获取题目列表
     * @param question
     * @return
     */
    @PostMapping("/question/update")
    boolean updateQuestionById(@RequestBody Question question);

//    /**
//     * 根据题目ID获取题目列表
//     * @param question
//     * @return
//     */
//    @PostMapping("/question/update")
//    boolean updateById(@RequestBody Question question);
}
