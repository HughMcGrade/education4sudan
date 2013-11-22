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
  end

end
