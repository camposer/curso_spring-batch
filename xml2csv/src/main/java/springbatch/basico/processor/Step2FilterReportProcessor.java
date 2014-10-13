package springbatch.basico.processor;

import org.springframework.batch.item.ItemProcessor;

import springbatch.basico.model.Report;

public class Step2FilterReportProcessor implements ItemProcessor<Report, Report> {

	@Override
	public Report process(Report item) throws Exception {

		// filter object which age = 30
		if (item.getAge() <= 29) {
			return null; // null = ignore this object
		}
		return item;
	}

}