package org.launchcode.techjobs.oo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import static org.junit.Assert.*;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job2.getId(), job1.getId());

    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", job1.getName());
        assertTrue(job1.getName() instanceof String);
        assertEquals("ACME", job1.getEmployer().toString());
        assertTrue(job1.getEmployer() instanceof Employer);
        assertEquals("Desert", job1.getLocation().toString());
        assertTrue(job1.getLocation() instanceof Location);
        assertEquals("Quality control", job1.getPositionType().toString());
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertEquals("Persistence", job1.getCoreCompetency().toString());
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
    }
    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));

    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"), new PositionType("Back-end developer"), new CoreCompetency("Java"));
        char firstChar = job.toString().charAt(0);
        char lastChar = job.toString().charAt(job.toString().length()-1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"), new PositionType("Back-end developer"), new CoreCompetency("Java"));

        String jobString = job.toString();
        String expected = "\nID: " + job.getId() +
                "\nName: " + job.getName() +
                "\nEmployer: " + job.getEmployer() +
                "\nLocation: " + job.getLocation() +
                "\nPosition Type: " + job.getPositionType() +
                "\nCore Competency: " + job.getCoreCompetency() +
                "\n";
        assertEquals(expected, jobString);
    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Web Developer", new Employer(""), new Location("StL"), new PositionType(""), new CoreCompetency("Java"));

        String jobString = job.toString();
        String expected = "\nID: " + job.getId() +
                "\nName: " + job.getName() +
                "\nEmployer: " + (job.getEmployer().toString().isEmpty() ? "Data not available" : job.getEmployer()) +
                "\nLocation: " + (job.getLocation().toString().isEmpty() ? "Data not available" : job.getLocation()) +
                "\nPosition Type: " + (job.getPositionType().toString().isEmpty() ? "Data not available" : job.getPositionType()) +
                "\nCore Competency: " + (job.getCoreCompetency().toString().isEmpty() ? "Data not available" : job.getCoreCompetency()) +
                "\n";
        assertEquals(expected, jobString);
    }

}