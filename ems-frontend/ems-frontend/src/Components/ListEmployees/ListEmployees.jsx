import React, {useEffect, useState} from 'react'
import { listEmployees } from '../../Service/EmployeeService'
import { useNavigate } from 'react-router-dom'
import './ListEmployees.css'

const ListEmployees = () => {

    const [employees, setEmployees] = useState([])

    const navigator = useNavigate();

    useEffect(() => {
        listEmployees().then((response) =>  {
            setEmployees(response.data);
        }).catch(error => {
            console.error(error);
        })
    }, [])

    function addNewEmployee() {
        navigator("/add-employee")
    }

    function updateEmployee(id) {
        navigator(`/edit-employee/${id}`)
    }

  return (
    <div className='container'>
        <h2 className='text-center'>List of Employees</h2>
        <button className='btn btn-success mb-2' onClick={addNewEmployee}>Add an Employee</button>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Employee ID</th>
                    <th>Employee First Name</th>
                    <th>Employee Last Name</th>
                    <th>Employee Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {
                    employees.map(employee => 
                        <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.firstName}</td>
                            <td>{employee.lastName}</td>
                            <td>{employee.email}</td>
                            <td>
                                <button className='btn btn-primary' onClick={() => updateEmployee(employee.id)}>Update</button>
                            </td>
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListEmployees