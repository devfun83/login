package com.example.login.service;
 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
 
import com.example.login.dto.MembersDto;
import com.example.login.repository.MembersRepository;
 
import lombok.RequiredArgsConstructor;
 
@RequiredArgsConstructor
@Service
public class JoinService {
 
    private final MembersRepository membersRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    
    /**
     * 회원가입
     * @param membersDto
     * @return
     */
    public boolean joinProc(MembersDto membersDto) {
 
        // 회원 존재 여부 확인
        boolean isMembers = membersRepository.existsByLoginId(membersDto.getLoginId());
 
        if (!isMembers) {
            // 회원 저장
            membersDto.setLoginPwd(bCryptPasswordEncoder.encode(membersDto.getLoginPwd())); // 시큐리티 암호화
            membersDto.setRole("ROLE_USER");  // or "ROLE_ADMIN"
 
            membersRepository.save(membersDto.toEntity());
        }
 
        return isMembers;
    }
    
}