package vu.lt.fishing.myBatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import vu.lt.fishing.myBatis.model.Lake;

@Mapper
public interface LakeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.LAKE
     *
     * @mbg.generated Wed Apr 14 13:22:25 EEST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.LAKE
     *
     * @mbg.generated Wed Apr 14 13:22:25 EEST 2021
     */
    int insert(Lake record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.LAKE
     *
     * @mbg.generated Wed Apr 14 13:22:25 EEST 2021
     */
    Lake selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.LAKE
     *
     * @mbg.generated Wed Apr 14 13:22:25 EEST 2021
     */
    List<Lake> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.LAKE
     *
     * @mbg.generated Wed Apr 14 13:22:25 EEST 2021
     */
    int updateByPrimaryKey(Lake record);

    List<Lake> selectByName(String name);

    List<String> selectAllNames();
}