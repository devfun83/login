package com.example.oauth2.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
import com.example.oauth2.entity.Members;
 
public interface MembersRepository extends JpaRepository<Members, Integer> {
 
    // 회원 정보 조회
    Members findByUserid(String userid);
 
}