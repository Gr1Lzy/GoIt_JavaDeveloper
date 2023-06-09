SELECT project.*, DATEDIFF('MONTH', project.START_DATE, project.FINISH_DATE) AS duration_months
FROM project
WHERE DATEDIFF('MONTH', project.START_DATE, project.FINISH_DATE) =
      (SELECT MAX(DATEDIFF('MONTH', project.START_DATE, project.FINISH_DATE))
       FROM project)
