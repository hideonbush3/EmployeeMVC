package project.spring4.mvc.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import project.spring4.mvc.employee.service.EmployeeService;

// 클래스가 컨트롤러임을 알리는 @Controller 애너테이션
@Controller
public class EmployeeController {
    private EmployeeService empsrv;

    @Autowired
    public EmployeeController(EmployeeService empsrv){this.empsrv = empsrv;}

    // @GetMapping은 설정된 파라미터와 같은 요청(/list)이 있을때 메서드(list())를 수행시킴
    // 요청에 해당하는 비지니스 로직(list() 메서드) 을 찾아주고
    // 뷰에서 사용할 모델과 요청을 처리할 뷰이름을 디스패처 서블릿 반환하고 알려준다
    @GetMapping(value = "/list")
    public ModelAndView list () {
        ModelAndView mv = new ModelAndView();

        mv.addObject("emps", empsrv.readEmployee());
        mv.setViewName("emplist");

        return mv;
    }
}
