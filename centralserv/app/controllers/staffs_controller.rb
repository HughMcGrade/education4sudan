class StaffsController < ApplicationController

  def index
    @staffs = Staff.all
  end

  def new
    @staff = Staff.new
  end

  def show
    @staff = Staff.find(params[:id])
  end

  def create
    @staff = Staff.create(staff_params)
    # @staff.image_url = Photo.all.sample.image_url unless @staff.image_url
    redirect_to school_path(@staff.school_id), :notice => "Staff member added successfully!"
  end

  private

  def staff_params
    params.require(:staff).permit(:name, :image_url, :role, :school_id)
  end

end
