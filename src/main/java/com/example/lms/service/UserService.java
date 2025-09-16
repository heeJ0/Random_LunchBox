package com.example.lms.service;
import com.example.lms.domain.user.UserRepository;
import com.example.lms.domain.user.UserRequestDTO;
import com.example.lms.domain.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired // 서비스 repository 에 자동으로 연동해주는 것
    private UserRepository userRepository;

    // CRUD
    // 1. Create
    public void createUser(UserRequestDTO userRequestDto){
        UserVO user = new UserVO(userRequestDto);
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(UserRequestDTO dto){
//        userRepository.deleteById(dto.getId());
//        System.out.println("deleteUser: "+dto.getUsercode());
        UserVO vo = new UserVO(dto);
        userRepository.delete(vo);
    }

    public UserVO readUser(UserRequestDTO userRequestDto){
        List<UserVO> result = userRepository.findByStringId(userRequestDto.getId());
       if(result.isEmpty())
           return null;
       return result.get(0);
    }

    public UserVO readUserPw(UserRequestDTO userRequestDto){
        System.out.println("UserService: "+userRequestDto.getUsercode());
        System.out.println("USER PASS: "+userRequestDto.getPw());

        List<UserVO> result = userRepository.findByStringCodePw(userRequestDto.getUsercode(), userRequestDto.getPw());

        if(result.isEmpty())
            return null;
        return result.get(0);
    }

    public boolean checkId(String id){
        // 동일아이디가 있으면 false로 반환
        System.out.println("SERVICE!!");
        List<UserVO> result = userRepository.findAll();
        for(int i=0; i< result.size(); i++){
            if(id.equals(result.get(i).getId())){
                return false;
            }
        }
        return true;
    }

    public UserVO updateUser(UserRequestDTO userRequestDto){
        UserVO user = userRepository.findById(userRequestDto.getUsercode()).orElseThrow(
                () -> new IllegalArgumentException("존재하지않는 회원정보")
        );
        user.updateUser(userRequestDto);
        userRepository.save(user);

        return user;
    }

    //usercode로 유저검색
    public UserVO readCode(UserRequestDTO dto){
        UserVO result = userRepository.findById(dto.getUsercode()).orElseThrow(
                () -> new IllegalArgumentException("존재하지않는 회원정보")
        );
        System.out.println(result);
        return result;
    }
}
