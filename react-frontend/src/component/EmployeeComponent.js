import React, { Component } from 'react';
import EmployeeService from '../service/EmployeeService';

class EmployeeComponent extends Component {
    
    constructor(props) {
        super(props);
        
        this.state = {
            employee: {},
            department: {},
            organization: {}
        }
    }
    
    componentDidMount(){
        EmployeeService.getEmployee().then((Response) => {
            this.setState({employee : Response.data.employee});
            this.setState({department : Response.data.department});
            this.setState({organization : Response.data.organization});

            console.log(this.state.employee);
            console.log(this.state.department);
            console.log(this.state.organization);

        })
    }

    render() {
        return (
            <div><br /><br />
                <div className='card col-md-6 offset-md-3'>
                    <h3 className='text-center card-header'>View Employee Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Employee First Name: </strong>{this.state.employee.firstName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Employee First Name: </strong>{this.state.employee.lastName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Employee First Name: </strong>{this.state.employee.email}</p>
                        </div>
                    </div>
                    <h3 className='text-center card-header'>View Department Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Department Name: </strong>{this.state.department.departmentName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Department description: </strong>{this.state.department.departmentDescription}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Department code: </strong>{this.state.department.departmentCode}</p>
                        </div>
                    </div>
                    <h3 className='text-center card-header'>View Organisation Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <p><strong>Organzsation Name: </strong>{this.state.organization.organizationName}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Organization description: </strong>{this.state.organization.organizationDescription}</p>
                        </div>
                        <div className='row'>
                            <p><strong>Organization code: </strong>{this.state.organization.organizationCode}</p>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default EmployeeComponent;