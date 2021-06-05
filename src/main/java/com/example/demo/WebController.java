package com.example.demo;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import dao.BookDao;
import dao.UserDao;
import dto.BookDto;
import service.BookService;
import service.UserService;
import dto.UserDto;

@Controller
public class WebController {
	@Autowired
	private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;

    //메인화면
    @RequestMapping( {"/", "/main"} )//기본디렉터리,main접속시
	public String main(Model model,HttpServletRequest request) {
    	/*세션생성,존재할경우 id값을 넘겨준다*/
    	HttpSession session = request.getSession();
		if(session.getAttribute("user")!=null) {
			System.out.println("session id 처리 : "+ (String)session.getAttribute("id"));
			
		}
    	System.out.println("main IN");
		return "main";
	}
    
    //로그인화면
    @RequestMapping(value="/login")		// 컨트롤 할 URL을 지정해준다. URL의 path 부분을 작성해주면 된다.
	public String login(Model model) {
		return "login";		// View의 폴더, 파일 이름을 문자열로 리턴해준다.
	}
    
    //회원가입 화면
	@RequestMapping(value="/signin")		// 컨트롤 할 URL을 지정해준다. URL의 path 부분을 작성해주면 된다.
	public String signin(Model model) {
		model.addAttribute("userRegisterRequest", new UserRegisterRequest());
		return "signin";		// View의 폴더, 파일 이름을 문자열로 리턴해준다.
	}
	@RequestMapping(value="/booktable", method = RequestMethod.GET)		// 컨트롤 할 URL을 지정해준다. URL의 path 부분을 작성해주면 된다.
	public String table(Model model) {
		List<BookDto> bookList = bookDao.selectAll();
		model.addAttribute("bookList", bookList);
		return "booktable";		// View의 폴더, 파일 이름을 문자열로 리턴해준다.
	}
	@RequestMapping(value="/adminbook", method = RequestMethod.GET)		// 컨트롤 할 URL을 지정해준다. URL의 path 부분을 작성해주면 된다.
	public String adminbook(Model model) {
		List<BookDto> bookList = bookDao.selectAll();
		model.addAttribute("bookList", bookList);
		return "adminbook";		// View의 폴더, 파일 이름을 문자열로 리턴해준다.
	}
	@RequestMapping(value="/usertable", method = RequestMethod.GET)		// 컨트롤 할 URL을 지정해준다. URL의 path 부분을 작성해주면 된다.
	public String usertable(Model model) {
		List<UserDto> userList = userDao.selectAll();
		model.addAttribute("userList", userList);
		return "usertable";
	}
	@RequestMapping(value="/userinfo")
	public String userInfo(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("user");
		model.addAttribute("id", userDto.getId());
		model.addAttribute("email", userDto.getEmail());
		model.addAttribute("name", userDto.getName());
		model.addAttribute("phoneNumber", userDto.getPhoneNumber());
		model.addAttribute("userDto", userDto);
		return "userinfo";
	}
	@RequestMapping(value="/loginAction",method = RequestMethod.POST)
	public String loginCheck(HttpServletRequest request) {
		UserDto user = userService.userSearch(request.getParameter("id"));
		HttpSession session = request.getSession();
		session.setAttribute("user",user);
		session.setAttribute("id", user.getId());
		session.setAttribute("name",user.getName());
		return "main";
	}
	
	@RequestMapping(value = "/signInAction", method = RequestMethod.POST)
	public String handleSignIn(UserRegisterRequest userRegReq,HttpServletRequest request) {
		System.out.println("signInAction IN");
		 try {
             userService.regist(userRegReq);
             return "main";
       } catch (Exception ex) {
             return "signin";
       }
	}
	@RequestMapping(value = "/reUserInfoAction", method = RequestMethod.POST)
	public String reUserInfo(UserRegisterRequest userRegReq,HttpServletRequest request) {
		System.out.println("signInAction IN");
		 try {
             userService.regist(userRegReq);
             return "main";
       } catch (Exception ex) {
             return "signin";
       }
	}
	
	@RequestMapping(value="/bookadd")		// 컨트롤 할 URL을 지정해준다. URL의 path 부분을 작성해주면 된다.
	public String bookadd(Model model) {
		return "bookadd";		// View의 폴더, 파일 이름을 문자열로 리턴해준다.
	}
    @RequestMapping(value="/bookAddAction", method = RequestMethod.POST)
    public String bookAddAction(Model model, HttpServletRequest request) {
		System.out.println("bookAddAction IN");
		String bookName= request.getParameter("bookName");
		String author= request.getParameter("author");
		String publishingHouse= request.getParameter("publishingHouse");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String price= request.getParameter("price");
		BookRegisterRequest bookRegReq = new BookRegisterRequest();
		bookRegReq.setAuthor(author);
		bookRegReq.setBookName(bookName);
		bookRegReq.setCurrentCount(1);
		bookRegReq.setPrice(Integer.valueOf(price));
		bookRegReq.setPublicationDateByYMD(year, month, day);
		bookRegReq.setPublishingHouse(publishingHouse);
		bookService.addBook(bookRegReq);

		return "bookadd";
	}
    @RequestMapping(value="/logout")
    public String logout(Model model, HttpSession session) {
    	session.invalidate();//session 삭제
    	return "redirect:/";
    }
    @RequestMapping(value="/showid")
    public String showId(Model model,HttpSession session) {
    	return "showid";
    }
    @RequestMapping(value="/showpw")
    public String showPw(Model model,HttpSession session) {
    	return "showpw";
    }
    
    @RequestMapping(value="/findpw")
    public String findPw(Model model,HttpSession session) {
    	return "findpw";
    }
    @RequestMapping(value="/findid")
    public String findId(Model model,HttpSession session) {
    	return "findid";
    }
    @RequestMapping(value="/renttable", method = RequestMethod.GET)		// 컨트롤 할 URL을 지정해준다. URL의 path 부분을 작성해주면 된다.
	public String rentTable(Model model) {
		List<BookDto> bookList = bookDao.selectAll();
		model.addAttribute("bookList", bookList);
		return "renttable";		// View의 폴더, 파일 이름을 문자열로 리턴해준다.
	}
    @RequestMapping(value="/reuserinfo",method = RequestMethod.POST)
    public String reUserInfo(Model model,HttpServletRequest request) {
    	HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("user");
		model.addAttribute("id", userDto.getId());
		model.addAttribute("email", userDto.getEmail());
		model.addAttribute("name", userDto.getName());
		model.addAttribute("phoneNumber", userDto.getPhoneNumber());
		model.addAttribute("userDto", userDto);
    	return "reuserinfo";
    }
    
    
    
    
    
    
    
    
    /************/
    
	/*
	 * @RequestMapping("/register/step1") public String handleStep1() { return
	 * "register/step1"; }
	 * 
	 * 
	 * @PostMapping("/register/step2") public String handleStep2(@RequestParam(value
	 * = "agree", defaultValue = "false") Boolean agree, Model model) { if (!agree)
	 * { return "register/step1"; } model.addAttribute("registerRequest", new
	 * RegisterRequest()); return "register/step2"; }
	 * 
	 * @GetMapping("/register/step2") public String handleStep2Get() { return
	 * "redirect:/register/step1"; }
	 * 
	 */
	/*
	 * @PostMapping("/register/step3") public String handleStep3(RegisterRequest
	 * regReq) { try { memberRegisterService.regist(regReq); return
	 * "register/step3"; } catch (Exception ex) { return "register/step2"; } }
	 */
    
	/*
	 * @RequestMapping(value = "/register/step3", method = RequestMethod.POST)
	 * public String handleStep3(HttpServletRequest request) { String email =
	 * request.getParameter("email"); String name = request.getParameter("name");
	 * System.out.println("step3: "+name); String password =
	 * request.getParameter("password"); String confirmPassword =
	 * request.getParameter("confirmPassword"); RegisterRequest regReq = new
	 * RegisterRequest(); regReq.setEmail(email); regReq.setName(name); try {
	 * memberRegisterService.regist(regReq); return "register/step3"; } catch
	 * (Exception ex) { return "register/step2"; } }
	 */

}
