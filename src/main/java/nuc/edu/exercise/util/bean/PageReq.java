package nuc.edu.exercise.util.bean;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <Description>
 *
 * @author yalin.gao@shunyagroup.com
 * @version 1.0
 * @date 2020/07/29
 */
public class PageReq implements Serializable {

	@NotNull(message = "page 不能为空")
	private Integer page;//请求的页数
	@NotNull(message = "pageSize 不能为空")
	private Integer pageSize;//每页的记录数


	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
