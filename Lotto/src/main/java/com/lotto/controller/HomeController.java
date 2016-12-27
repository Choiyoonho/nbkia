package com.lotto.controller;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lotto.dto.LottoDTO;

@Controller
public class HomeController {
	@SuppressWarnings("resource")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		List<LottoDTO> lottoList = new ArrayList<LottoDTO>();
		
		POIFSFileSystem excel = new POIFSFileSystem(new FileInputStream("c:\\test\\lotto.xls"));
		HSSFWorkbook workbook = null;
		
		workbook = new HSSFWorkbook(excel);
		HSSFSheet curSheet;
		HSSFRow curRow;
		HSSFCell curCell;
		LottoDTO dto;
		
		HashMap<Integer, Integer> lottoResult = new HashMap<Integer, Integer>();
		//int[] newNumber = new int[6];
		List<Integer> newNumber = new ArrayList<Integer>();
		for(int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++){
			curSheet = workbook.getSheetAt(sheetIndex);
			for(int rowIndex = 0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++){
				if(rowIndex != 0){
					curRow =curSheet.getRow(rowIndex);
					dto = new LottoDTO();
					int value = 0;
					if(!"".equals(curRow.getCell(0).getNumericCellValue())){
						for(int cellIndex = 0; cellIndex < curRow.getPhysicalNumberOfCells(); cellIndex++){
							curCell = curRow.getCell(cellIndex);
							
							/*if(true){
								switch(curCell.getCellType()){
								case HSSFCell.CELL_TYPE_NUMERIC :
									value = (int) curCell.getNumericCellValue();
									break;
								}*/
								switch(cellIndex){
								case 0 :
									dto.setNum1(value);
								case 1 :
									dto.setNum2(value);
								case 2 :
									dto.setNum3(value);
								case 3 :
									dto.setNum4(value);
								case 4 :
									dto.setNum5(value);
								case 5 :
									dto.setNum6(value);
								case 6 :
									dto.setBonus(value);
								default :
									break;
								}
							//}
						}
						lottoList.add(dto);
					}
				}
			}
		}
		int[] count = new int[]{
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0
		};
		
		for(int i = 0; i < lottoList.size(); i++){
			for(int j = 1; j <= 45; j++){
				if(lottoList.get(i).getNum1() == j){
					count[j-1]++;
				}else if(lottoList.get(i).getNum2() == j){
					count[j-1]++;
				}else if(lottoList.get(i).getNum3() == j){
					count[j-1]++;
				}else if(lottoList.get(i).getNum4() == j){
					count[j-1]++;
				}else if(lottoList.get(i).getNum5() == j){
					count[j-1]++;
				}else if(lottoList.get(i).getNum6() == j){
					count[j-1]++;
				}else if(lottoList.get(i).getBonus() == j){
					count[j-1]++;
				}
			}
		}
		for(int i = 0; i < 45; i++){
			lottoResult.put(i + 1 , count[i]);
		}
		
		int numbering = 0;
		while(newNumber.size() < 6){
			numbering = (int)(Math.random() * 45 + 1); 
			if(newNumber.isEmpty()){
				newNumber.add(numbering);
			}else{
				if(!newNumber.contains(numbering)){
					newNumber.add(numbering);
				}
			}
		}
		
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>(lottoResult);
		Iterator<Integer> iteratorKey = tm.keySet().iterator();	//키값 오름차순 정렬
		
		newNumber.sort(null);
		System.out.print(newNumber.get(0) + "\t");
		System.out.print(newNumber.get(1) + "\t");
		System.out.print(newNumber.get(2) + "\t");
		System.out.print(newNumber.get(3) + "\t");
		System.out.print(newNumber.get(4) + "\t");
		System.out.println(newNumber.get(5));
		model.addAttribute("lottoResult", iteratorKey);
		System.out.println("총 회차 : " + lottoList.size());
		return "home";
		// 2 7 13 25 42 45             39
	}
}
