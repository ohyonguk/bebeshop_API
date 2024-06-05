package com.bebe.spring.admin.dao;

import java.util.List;

import com.bebe.spring.vo.OptionsVO;
import com.bebe.spring.vo.OrdersSearchVO;
import com.bebe.spring.vo.OrdersVO;
import com.bebe.spring.vo.ProductOptionsVO;
import com.bebe.spring.vo.ProductSearchVO;
import com.bebe.spring.vo.UsersVO;

public interface AdminDao {
	Integer updatePasswd(String passwd);
	Integer insertProduct(ProductOptionsVO productOpVo);
	List<UsersVO> selectUsers(String searchWord);
	Integer deleteUser(String id);
	List<ProductOptionsVO> selectProductList(ProductSearchVO psVo);
	List<OptionsVO> selectOptions();
	Integer deleteProduct(int checkproductno);
	Integer deleteOptions(int checkproductno);
	Integer deleteQuestion(int checkproductno);
	Integer deleteAnswer(int checkproductno);
	Integer deleteReview(int checkproductno);
	Integer insertOptions(OptionsVO optionsVo);
	List<OrdersVO> selectOrdersList(OrdersSearchVO osVo);
	Integer updateOrderSts(OrdersVO orderVo);
	Integer updateSales(OrdersVO orderVo);
	Integer updateStock(OrdersVO orderVo);
}
