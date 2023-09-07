package nuc.edu.exercise.dao;

import java.util.List;
import nuc.edu.exercise.model.SeckillProducts;
//import nuc.edu.search.util.bean.CommonQueryBean;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * SeckillProducts数据库操作接口类
 * 
 **/

@Repository
public interface SeckillProductsDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	SeckillProducts  selectByPrimaryKey ( @Param("id") Long id );

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	int deleteByPrimaryKey ( @Param("id") Long id );

	/**
	 * 
	 * 添加
	 * 
	 **/
	int insert( SeckillProducts record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( SeckillProducts record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
//	List<SeckillProducts> list4Page ( SeckillProducts record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	long count ( SeckillProducts record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<SeckillProducts> list ( SeckillProducts record);

}