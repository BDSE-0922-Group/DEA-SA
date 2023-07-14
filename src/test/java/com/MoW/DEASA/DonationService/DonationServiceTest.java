package com.MoW.DEASA.DonationService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.MoW.DEASA.Entity.Donation;
import com.MoW.DEASA.Repo.DonationRepository;
import com.MoW.DEASA.Service.DonationService;

@RunWith(MockitoJUnitRunner.class)
public class DonationServiceTest {

	@Mock
	DonationRepository donationRepository;
	
	@InjectMocks
	DonationService donationService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveDonationData() {
		Donation donation = new Donation();
		donation.setId((long)1);
		donation.setIntent("sale");
		donation.setMethod("paypal");
		donation.setAmount(100.0);
		donation.setCurrency("USD");
		donation.setDonId((long)2);
		donation.setDate("Tuesday 04 July 2023");
		Mockito.when(donationRepository.save(donation)).thenReturn(donation);
		String donationResponse = donationService.save(donation);
		Assert.assertEquals("Donation saved successfully", donationResponse);
	}
}
