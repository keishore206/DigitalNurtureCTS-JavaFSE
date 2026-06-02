SELECT u.full_name, e.status, COUNT(*) AS total_events FROM Users u JOIN Events e ON u.user_id = e.organizer_id GROUP BY u.full_name, e.status;
