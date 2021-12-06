<template>
  <tr class="patient-info">
      <td id = "patient-id">{{patient.patientId}}</td>
      <td id = "patient-first-name">{{patient.firstName}}</td>
      <td id = "patient-last-name">{{patient.lastName}}</td>
      <td id = "patient-date-of-birth">{{patient.dateOfBirth}}</td>
      <td id = "patient-address">{{patient.patientAddress}}</td>
</template>

<script>
export default {
    data() {
        return {
            patient: {
                patientId: '',
                firstName: '',
                lastName: '',
                dateOfBirth: '',
                patientAddress: '',
            }
        }
    }
}
</script>

<style>

</style>