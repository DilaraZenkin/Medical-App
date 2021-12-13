<template>
    <div>
        <tr class="office-header">
            <td>Office Id Number </td>
            <td>Office Address </td>
            <td>Office Phone Number  </td>
            <td>Office Open  </td>
            <td>Office Close </td>
            <td>Hourly Cost </td>
        </tr>    
        <tr class="office-info">
            <td id = "office-id">{{office.officeId}}</td>
            <td id = "office-address">{{office.address}}</td>
            <td id = "office-phone-number">{{office.phoneNumber}}</td>
            <td id = "office-open">{{office.open}}</td>
            <td id = "office-close">{{office.close}}</td>
            <td id = "office-hourly-cost">{{office.hourlyCost}}</td>
        </tr>
    </div>    
</template>

<script>

export default {
    name: 'office-information',
    data() {
        return {
            office: {
                officeId: '',
                address: '',
                phoneNumber: '',
                open: '',
                close: '',
                hourlyCost: '',
            }
        };
    },
    // created() {
    //     OfficeService.getOffice(this.$route.params.OfficeId).then(response => {
    //         this.office = response.data;
    //     })
    // }
}
</script>

<style>

</style>