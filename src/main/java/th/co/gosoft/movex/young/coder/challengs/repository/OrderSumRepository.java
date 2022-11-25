package th.co.gosoft.movex.young.coder.challengs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import th.co.gosoft.movex.young.coder.challengs.entity.OrderSumEntity;

@Repository
public interface OrderSumRepository extends JpaRepository<OrderSumEntity,Integer>{
	String SQL_QUERY_FIND_ERROR_DATA ="SELECT pi.d_pick, po.S_EXTERN_ORDERNO ,  pi.s_th_invoice , box.I_BOXID \r\n"
			+ "FROM p_ordsum po \r\n"
			+ "LEFT JOIN p_invsum  pi ON po.I_ORDER = pi.i_order\r\n"
			+ "LEFT JOIN p_box_onbook box ON box.i_order = pi.i_order\r\n"
			+ "WHERE po.D_CREATE  = to_date(sysdate-1)\r\n"
			+ "AND (pi.S_TH_INVOICE IS NULL OR box.I_BOXID IS NULL)";
	
	@Transactional
	@Query(value = SQL_QUERY_FIND_ERROR_DATA, nativeQuery = true)
	List<String[]> findErrorData();
}
