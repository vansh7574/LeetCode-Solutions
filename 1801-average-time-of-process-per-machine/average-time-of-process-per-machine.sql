/* Write your T-SQL query statement below */
with Start_Times as (

    Select machine_id, process_id, activity_type as All_Starts, timestamp as Start_Timestamp from Activity where activity_type = 'start'
),
End_Times as (

    Select machine_id, process_id, activity_type as All_Ends, timestamp as End_Timestamp from Activity where activity_type = 'end'
)


Select s.machine_id, ROUND(AVG(End_Timestamp - Start_Timestamp), 3) as processing_time from Start_Times s Join End_Times e on s.machine_id = e.machine_id and s.process_id = e.process_id group by s.machine_id 