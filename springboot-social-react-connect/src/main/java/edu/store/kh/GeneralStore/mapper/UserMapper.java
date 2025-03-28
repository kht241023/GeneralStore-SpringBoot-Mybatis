package edu.store.kh.GeneralStore.mapper;

import edu.store.kh.GeneralStore.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {


    // 유저 로그인 유저 정보를 가져올 것
    User findUserId(@Param("userId") String userId);
    User loginUser(@Param("userId")String userId, @Param("password")String password);
    /*
    만약에 값이 달라서 발생하는 오류 라며 아래와 같은 명칭 변경 요청
    컬럼명 / 변수명 / 파    라     미    터    명   칭  /  name 에 작성한 변수이름 상태 관리 명칭
    SQL   -> DTO   -> Mapper -> ServiceImpl -> Controller -> html or javaScript
    에서 명칭이 다른 것끼리 전달하려 하지 않았는지 확인

    User findUserId(@Param("userId")String userId);
    User loginUser(@Param("userId")String userId, @Param("password")String password);
    *
    */
}
