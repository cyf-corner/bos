package top.flyroc.bos.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import top.flyroc.bos.domain.Region;
import top.flyroc.bos.service.IRegionService;
import top.flyroc.bos.utils.PinYin4jUtils;
import top.flyroc.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region> {

	@Autowired
	private IRegionService regionService;

	// 属性注入
	private File regionFile;

	public void setRegionFile(File regionFile) {
		this.regionFile = regionFile;
	}

	/*
	 * 导入Excel文件(技术点OCUpload+POI)
	 */
	public String importXls() throws Exception {
		List<Region> regionList = new ArrayList<Region>();
		// 使用POI解析上传的Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(regionFile));
		HSSFSheet sheet = workbook.getSheet("Sheet1");// 读取第一个Sheet标签页
		for (Row row : sheet) {
			if (row.getRowNum() == 0) {// 刨除第一行表头不读
				continue;
			}
			String id = row.getCell(0).getStringCellValue();
			String province = row.getCell(1).getStringCellValue();
			String city = row.getCell(2).getStringCellValue();
			String district = row.getCell(3).getStringCellValue();
			String postcode = row.getCell(4).getStringCellValue();

			// 包装一个区域对象
			Region region = new Region(id, province, city, district, postcode, null, null, null);

			// shortcode HBSJZZD
			province = province.substring(0, province.length() - 1);
			city = city.substring(0, city.length() - 1);
			district = district.substring(0, district.length() - 1);
			String info = province + city + district;
			String[] headByString = PinYin4jUtils.getHeadByString(info);
			String shortcode = StringUtils.join(headByString);

			// citycode---->>shijiazhuang
			String citycode = PinYin4jUtils.hanziToPinyin(city, "");

			region.setShortcode(shortcode);
			region.setCitycode(citycode);

			// 放入集合regionList中，至service层进行保存操作
			regionList.add(region);
		}
		// 批量保存
		regionService.saveBatch(regionList);
		workbook.close();

		return NONE;
	}

	/*
	 * 分页查询
	 */
	public String pageQuery() throws IOException {
		regionService.pageQuery(pageBean);
		java2Json(pageBean, new String[] { "currentPage", "detachedCriteria", "pageSize", "subareas" });

		return NONE;
	}

	// 属性驱动
	private String q;// combobox当设置为“remote”模式时，用户输入将被发送到名为'q'的HTTP请求参数到服务器检索新数据。

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	/*
	 * 生成区域列表ajax数据====>发送往subarea.jsp页面的combobox下拉框显示
	 */
	public String listAjax() {
		List<Region> regionList = null;
		if (StringUtils.isNotBlank(q)) {
			regionList = regionService.getRegionListByQ(q);
		} else {
			regionList = regionService.findAll();
		}
		this.java2Json(regionList, new String[] { "subareas" });

		return NONE;
	}

}
