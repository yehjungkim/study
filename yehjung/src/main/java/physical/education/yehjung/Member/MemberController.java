package physical.education.yehjung.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;


    @GetMapping("/get")
    public String getTest() {

        System.out.println("ewrewfdfsdfsdfwerwerwetweggrgrgrgrgrgrgrgrgrg");

        return "success";
    }

    @GetMapping(value = "/register", produces = "text/html")
    public String register(@ModelAttribute Member member) {
        if (member.getId() != null) {
            memberRepository.save(member);
            return "success";
        } else {
            return "fail";
        }
    }

    @GetMapping("login")
    public String login(@ModelAttribute Member reqMember){
        Optional<Member> member = memberRepository.findById(reqMember.getId());
        System.out.println(member.get().getEmail());
        System.out.println(member.get().getPw());
        if(member == null)
            return "fail";

        if(member.get().getPw().equals(reqMember.getPw())){
            return "success";
        }else{
            return "fail";
        }
    }

//    @GetMapping("/register")
//    public String register(@RequestParam("id") Long id,
//                           @RequestParam("nickName") String nickName,
//                           @RequestParam("email") String email,
//                           @RequestParam("pw") String pw){
//
//        System.out.println(id);
//        System.out.println(nickName);
//        System.out.println(email);
//        System.out.println(pw);
//
//        if(id != null) {
//            Member member = new Member();
//            member.setId(id);
//            member.setNickName(nickName);
//            member.setEmail(email);
//            member.setPw(pw);
//
//            memberRepository.save(member);
//
//            return "success";
//        }else {
//
//            return "fail";
//        }
//
//
//    }
}
