package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.Job;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.CoreCompetency;
import org.launchcode.techjobs_oo.PositionType;

import static org.junit.Assert.assertEquals;


public class JobTest {
    Job job1;
    Job job2;

    @Before
    public void createEmptyJob(){
        job1 = new Job();
        job2 = new Job();
    }

    @Test
    public void testSettingJobId(){
        assertEquals(job1.getId(), job2.getId()-1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(newJob.getName(), "Product tester");
        assertEquals(newJob.getEmployer().getValue(), "ACME");
        assertEquals(newJob.getLocation().getValue(), "Desert");
        assertEquals(newJob.getPositionType().getValue(), "Quality control");
        assertEquals(newJob.getCoreCompetency().getValue(), "Persistence");
        assertEquals(newJob.getEmployer() instanceof Employer, true);
        assertEquals(newJob.getLocation() instanceof Location, true);
        assertEquals(newJob.getPositionType() instanceof PositionType, true);
        assertEquals(newJob.getCoreCompetency() instanceof CoreCompetency, true);
    }

    @Test
    public void testJobsForEquality() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job newJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(newJob.equals(newJob2), false);
    }

    @Test
    public void testJobsToString() {
        Job newJob = new Job();
        newJob.setEmployer(new Employer("ACME"));
        newJob.setCoreCompetency(new CoreCompetency("Persistence"));
        newJob.setPositionType(new PositionType("Quality control"));
        newJob.setName("Product tester");
        String[] data = newJob.toString().split("\n");
        assertEquals(data[0], "     ");
        assertEquals(data[data.length-1], "     ");
        assertEquals(data[1].split(":")[0], "ID");
        assertEquals(data[2].split(":")[0], "Name");
        assertEquals(data[3].split(":")[0], "Employer");
        assertEquals(data[4].split(":")[0], "Location");
        assertEquals(data[4].split(":")[1], " data not available");
        assertEquals(data[5].split(":")[0], "Position Type");
        assertEquals(data[6].split(":")[0], "Core Competency");
    }
}
