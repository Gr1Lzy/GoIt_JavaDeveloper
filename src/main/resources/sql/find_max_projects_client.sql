SELECT c.NAME, COUNT(*) AS PROJECT_COUNT
FROM client c
         JOIN project p ON c.ID = p.CLIENT_ID
GROUP BY c.NAME
HAVING COUNT(*) = (
    SELECT MAX(project_count)
    FROM (
             SELECT COUNT(*) AS project_count
             FROM client c
                      JOIN project p ON c.ID = p.CLIENT_ID
             GROUP BY c.NAME
         ) AS counts
);