package org.sst.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.sst.service.ReportCardService;

public class RC_AverageCahrtAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ReportCardService service = ReportCardService.getInstance();
		List<HashMap> list2 = service.averageReportCard(request);

		JSONObject data = new JSONObject();
		JSONObject col1 = new JSONObject();
		JSONArray title = new JSONArray();

		col1.put("label", "INFO");
		col1.put("type", "string");
		title.add(col1);

		List<String> subjectList = (List<String>) request.getAttribute("subjectList");
		int i = 0;
		for (String sl : subjectList) {
			JSONObject col2 = new JSONObject();
			col2.put("label", subjectList.get(i++));
			col2.put("type", "number");
			title.add(col2);
		}

		data.put("cols", title);

		JSONArray body = new JSONArray();
		for (HashMap score : list2) {
			JSONArray row = new JSONArray();

			JSONObject info = new JSONObject();
			info.put("v", score.get("INFO")); // 상품이름 -> v 객체
			row.add(info);

			for (String sl : subjectList) {
				JSONObject sum = new JSONObject();
				sum.put("v", score.get(sl)); // 가격 ->v 객체
				row.add(sum);
			}

			JSONObject c = new JSONObject();
			c.put("c", row);
			body.add(c);
		}
		data.put("rows", body);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(data);
		return null;
	}

}
