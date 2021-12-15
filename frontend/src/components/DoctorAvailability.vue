<template>
  <v-app id="inspire">
    <v-content class="main">
      <v-container fluid>
        <v-layout justify-center align-center>
          <v-flex xs>
            <v-card
             v-bind:key="availability.id"
            v-for="availability in availabilities">
              <v-card-text>
                <div>Date: </div>
                <p class="text-h6 text--primary">{{availability.dayOfWeek}}</p>
                <div class="text--primary">
                From: {{availability.startTime}}
                </div>
                <div class="text--primary">
                 To: {{availability.endTime}}
                </div>
                <v-card-text>
                  Available: {{availability.available == true ? 'Yes' : 'No'}}
                </v-card-text>  
                   <v-btn class="update-availability-btn" @:click="updateForm = true; populateCurrent()">Change Availability</v-btn>
              </v-card-text>
              <div class="update-availability" v-show="updateForm">
                <v-form>
                  <!-- <v-chip-group
                      v-model="selection"
                      active-class="deep-purple accent-4 white--text"
                      column
                    >
                      <v-chip>5:30PM</v-chip>
                      <v-chip>7:30PM</v-chip>
                      <v-chip>8:00PM</v-chip>
                      <v-chip>9:00PM</v-chip>
                    </v-chip-group> -->
                  <v-chip-group
                    id="start"
                    prepend-icon=""
                    class="updateAvailability"
                    label="Start Time"
                    v-model="updatedAvailability.startTime"
                    active-class="deep-purple accent-4 white--text"
                    >
                    Start Time:
                    <v-spacer />
                      <v-chip>8:00AM</v-chip>
                      <v-chip>8:30AM</v-chip>
                      <v-chip>9:00AM</v-chip>
                      <v-chip>9:30AM</v-chip>
                      <v-chip>10:00AM</v-chip>
                      <v-chip>10:30AM</v-chip>
                      <v-chip>11:00AM</v-chip>
                    </v-chip-group>
                    <v-chip-group
                    id="end"
                    prepend-icon=""
                    class="updateAvailability"
                    label="End Time"
                    v-model="updatedAvailability.endTime"
                    active-class="deep-purple accent-4 white--text"
                    >
                    End Time:
                    <v-spacer />
                      <v-chip>1:00PM</v-chip>
                      <v-chip>1:30PM</v-chip>
                      <v-chip>2:00PM</v-chip>
                      <v-chip>2:30pm</v-chip>
                      <v-chip>3:00PM</v-chip>
                      <v-chip>3:30PM</v-chip>
                      <v-chip>4:00PM</v-chip>
                    </v-chip-group>
                    <v-checkbox
                    id="available"
                    prepend-icon=""
                    class="updateAvailability"
                    label="Available?"
                    v-model="updatedAvailability.available"
                    ></v-checkbox>
                    <v-btn type="submit" @submit.prevent="updateAvailability()">Update Availability</v-btn>
                    <v-btn type="reset" @:reset.prevent="cancelUpdate()">Cancel Update</v-btn>
                </v-form>
              </div>  
            </v-card>  
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
    <div id="app">
  <v-app id="inspire">
    <div class="text-center">
      <v-btn
        rounded
        color="primary"
        dark
        :to="{name: 'doctor-list'}"
      >
        Add Availability
      </v-btn>
    </div>
  </v-app>
</div>
  </v-app>
</template>

<script>
import AvailabilityService from '../services/AvailabilityService'
export default {
  name: "doctor-availability",
  data: () => ({
    enable: false,
    patient: {},
    doctor: {},
    updateForm: false,
    availabilities: [],
    updatedAvailability: {
      availabilityId: '',
      doctorId: '',
      dayOfWeek: '',
      startTime: '',
      endTime: '',
      available: '',
    },
  }),
  created() {
      AvailabilityService.getAvailability(this.$store.state.user.id).then(
        (response) => {
          this.availabilities = response.data;
        }
      );
  },
  methods: {
    resetForm() {
      this.showForm = false;
    },
    updateAvailability() {
      AvailabilityService.updateAvailability(this.updatedAvailability);
    },
    populateCurrent() {
      this.updatedAvailability.availabilityId = this.avability.availabilityId;
      this.updatedAvailability.doctorId = this.$store.state.user.id;
      this.updatedAvailability.dayOfWeek = this.avability.dayOfWeek;
      this.updatedAvailability.startTime = this.avability.startTime;
      this.updatedAvailability.endTime = this.avability.endTime;
      this.updatedAvailability.available = this.avability.available;
    },
    cancelUpdate() {
      this.updateForm = false;
      this.populateCurrent();
    }
  },
  
};
</script>

<style>
</style>