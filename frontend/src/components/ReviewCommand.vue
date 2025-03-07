<template>
    <v-card outlined>
        <v-card-title>
            Review
        </v-card-title>

        <v-card-text>
            <Number label="ReportId" v-model="value.reportId" :editMode="editMode"/>
            <String label="DeviceId" v-model="value.deviceId" :editMode="editMode"/>
            <Number label="ReviewerId" v-model="value.reviewerId" :editMode="editMode"/>
            <Status offline label="Status" v-model="value.status" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="review"
            >
                Review
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'ReviewCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.reportId = 0;
            this.value.deviceId = '';
            this.value.reviewerId = 0;
            this.value.status = {};
        },
        watch: {
        },
        methods: {
            review() {
                this.$emit('review', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

