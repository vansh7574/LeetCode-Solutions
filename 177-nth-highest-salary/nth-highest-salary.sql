CREATE FUNCTION getNthHighestSalary(@N INT)
RETURNS INT
AS
BEGIN
    DECLARE @result INT;

    IF @N <= 0
        SET @result = NULL;
    ELSE
        SELECT @result = salary
        FROM (
            SELECT DISTINCT salary
            FROM Employee
            ORDER BY salary DESC
            OFFSET (@N - 1) ROWS
            FETCH NEXT 1 ROW ONLY
        ) x;

    RETURN @result;
END;

