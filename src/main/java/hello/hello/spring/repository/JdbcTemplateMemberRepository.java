//package hello.hello.spring.repository;
//
//import hello.hello.spring.domain.Member;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//
//import javax.sql.DataSource;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//public class JdbcTemplateMemberRepository implements MemberRepository{
//
//    private final JdbcTemplate jdbcTemplate;
//
//    //생성자가 하나면 @Autowired 생략 가능
//    @Autowired
//    public JdbcTemplateMemberRepository(DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//    @Override
//    public Member save(Member member) {
//        //Insert 문
//        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
//        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");
//
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("name", member.getName());
//
//        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
//        member.setId(key.longValue()); //member의 setId!
//        return member;
//    }
//
//    @Override
//    public Optional<Member> findById(Long id) {
//        //jdbcTemplate에서 쿼리를 날려서 결과를 memberRowMapper을 통해 매핑을 하고 List로 받아서 Optional로 변환해서 반환
//        List<Member> result = jdbcTemplate.query("select * from member where id = ?", memberRowMapper(), id);
//        return result.stream().findAny(); //optional로 반환
//    }
//
//    @Override
//    public Optional<Member> findByName(String name) {
//        List<Member> result = jdbcTemplate.query("select * from member where name = ?", memberRowMapper(), name);
//        return result.stream().findAny(); //optional로 반환
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return jdbcTemplate.query("select * from member", memberRowMapper());
//    }
//
//    //member가 생성이 됨(객체 생성)
//    private RowMapper<Member> memberRowMapper() {
//        return new RowMapper<Member>() {
//            @Override
//            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//                //resultSet(결과)를 member(객체)로 매핑해 반환
//                Member member = new Member();
//                member.setId(rs.getLong("id"));
//                member.setName(rs.getString("name"));
//                return member;
//            }
//        };
//    }
//}
