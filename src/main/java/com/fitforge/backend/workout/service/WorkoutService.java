package com.fitforge.backend.workout.service;

import com.fitforge.backend.entity.User;
import com.fitforge.backend.workout.entity.Workout;
import com.fitforge.backend.workout.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public Workout addWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public Workout addWorkout(Workout workout, User user) {
        workout.setUser(user);
        return workoutRepository.save(workout);
    }

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public List<Workout> getUserWorkouts(User user) {
        return workoutRepository.findByUser(user);
    }

    public Workout getWorkoutById(Long id) {
        return workoutRepository.findById(id).orElse(null);
    }

    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }
}