-- 코드를 작성해주세요

SELECT HE.EMP_NO, HE.EMP_NAME, (
        CASE
            WHEN AVG(HG.SCORE) >= 96 THEN 'S'
            WHEN AVG(HG.SCORE) >= 90 THEN 'A'
            WHEN AVG(HG.SCORE) >= 80 THEN 'B'
            ELSE 'C'
            END) AS GRADE,
        (
            CASE
                WHEN AVG(HG.SCORE) >= 96 THEN HE.SAL * 0.2
                WHEN AVG(HG.SCORE) >= 90 THEN HE.SAL * 0.15
                WHEN AVG(HG.SCORE) >= 80 THEN HE.SAL * 0.10
                ELSE HE.SAL * 0
            END) AS BONUS
FROM HR_EMPLOYEES HE INNER JOIN HR_GRADE HG ON HE.EMP_NO = HG.EMP_NO
GROUP BY HE.EMP_NO
ORDER BY HE.EMP_NO;