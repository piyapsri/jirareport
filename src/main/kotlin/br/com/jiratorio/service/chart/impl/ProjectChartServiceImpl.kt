package br.com.jiratorio.service.chart.impl

import br.com.jiratorio.domain.entity.Issue
import br.com.jiratorio.domain.entity.embedded.Chart
import br.com.jiratorio.extension.log
import br.com.jiratorio.mapper.toChart
import br.com.jiratorio.service.chart.ProjectChartService
import org.springframework.stereotype.Service

@Service
class ProjectChartServiceImpl : ProjectChartService {

    override fun leadTimeByProject(issues: List<Issue>, uninformed: String): Chart<String, Double> {
        log.info("Method=leadTimeByProject, issues={}", issues)

        return issues
            .groupBy { it.project ?: uninformed }
            .mapValues { (_, value) -> value.map { it.leadTime }.average() }
            .toChart()
    }

    override fun throughputByProject(issues: List<Issue>, uninformed: String): Chart<String, Int> {
        log.info("Method=throughputByProject, issues={}", issues)

        return issues
            .groupingBy { it.project ?: uninformed }
            .eachCount()
            .toChart()
    }

}
