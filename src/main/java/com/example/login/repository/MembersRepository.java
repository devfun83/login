package com.example.login.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
import com.example.login.entity.Members;
 
public interface MembersRepository extends JpaRepository<Members, Integer> {
 
    // 회원 존재 여부 확인
    boolean existsByLoginId(String LoginId);
 
    // 회원 정보 조회
    Members findByLoginId(String LoginId);
 
}