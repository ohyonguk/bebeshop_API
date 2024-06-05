package com.bebe.spring.admin.service;

import java.util.List;

import com.bebe.spring.vo.OptionsVO;
import com.bebe.spring.vo.OrdersSearchVO;
import com.bebe.spring.vo.OrdersVO;
import com.bebe.spring.vo.ProductOptionsVO;
import com.bebe.spring.vo.ProductSearchVO;
import com.bebe.spring.vo.UsersVO;

public interface AdminService {
	//비밀번호 변경
	Integer updatePasswd(String passwd);
	
	//상품 추가
	Integer insertProduct(ProductOptionsVO productOpVo);
	
	//유저 데이터 검색
	List<UsersVO> selectUsers(String searchWord);
	
	//유저 삭제
	Integer deleteUser(String id);
	
	
	//상품 검색
	List<ProductOptionsVO> selectProductList(ProductSearchVO psVo);
	
	//모든 옵션 검색
	List<OptionsVO> selectOptions();
	
	// 선택 제품 삭제
	Integer deleteProduct(int[] id);
	
	// 삭제된 제품의 옵션삭제
	Integer deleteOthers(int[] checkproductno);
	
	//선택 옵션 추가
	Integer insertOptions(OptionsVO optionsVo);
	
	//주문내역 검색
	List<OrdersVO> selectOrdersList(OrdersSearchVO osVo);
	
	//주문상태 업데이트
	Integer updateOrderSts(OrdersVO orderVo);
	
	//주문취소시 판매량 감소
	Integer updateSales(OrdersVO orderVo);
	//주문취소시 재고 증가
	Integer updateStock(OrdersVO orderVo);
	
}
